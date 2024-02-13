#!/bin/bash

pr_number="$1"
release_title=$(gh pr view $pr_number --json "title" -q ".title")
release_body=$(gh pr view $pr_number --json "body" -q ".body" | sed -e '/## QA/,$d')
tag="release-$(echo "${release_title}" | awk 'match($0, /([0-9]+\.[0-9]+\.[0-9]+)/) {print substr($0, RSTART, RLENGTH)}')"

gh release create "$tag" -t "$release_title" -n "$release_body" --target main --latest
