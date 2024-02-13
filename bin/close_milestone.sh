#!/bin/bash

pr_number="$1"
milestone_title=$(gh pr view $pr_number --json "title" -q ".title")
milestone_number=$(gh api /repos/tick-taku/AndroidDoaminArchitecture/milestones -q ".[]|select(.title == \"${milestone_title}\") | .number")

gh api repos/tick-taku/AndroidDoaminArchitecture/milestones/$milestone_number -X PATCH -F state=closed
