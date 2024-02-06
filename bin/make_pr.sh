#!/bin/bash

new_version="$1"
pr_numbers=$(gh pr list --json "milestone,number" -q "[.[] | select(.milestone.title == \"Release ${new_version}\") | .number] | map(\"- #\" + tostring)|join(\"\\\n\")")
pr_body=$(cat .github/PULL_REQUEST/release.md | sed -e "s/# Release x\.x\.0/# Release ${new_version}/" | awk -v text="$pr_numbers" '/## Updates/{print;print text;next}1')

gh pr create \
  -B main \
  -t "Release $new_version" \
  -m "Release $new_version" \
  -b "$pr_body"
