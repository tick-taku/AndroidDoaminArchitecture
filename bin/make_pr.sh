#!/bin/bash

new_version="$1"
release_title="Release ${new_version}"

pr_numbers=$(gh pr list --json "milestone,number" -q "[.[] | select(.milestone.title == \"${release_title}\") | .number] | map(\"- #\" + tostring)|join(\"\\\n\")")
pr_body=$(cat .github/PULL_REQUEST/release.md | sed -e "s/# Release x\.x\.0/# ${release_title}" | awk -v text="$pr_numbers" '/## Updates/{print;print text;next}1')

gh pr create \
  -B main \
  -t "$release_title" \
  -m "$release_title" \
  -b "$pr_body"
