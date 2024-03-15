#!/bin/bash

project_number=1
project=$(gh project view $project_number --owner tick-taku --format json -q '.id')

status=$(gh project field-list $project_number --owner tick-taku --format json -q '.fields.[] | select(.name=="Status")')
status_id=$(echo "$status" | jq -r .id)
echo "status: $status_id"
released_status_id=$(echo "$status" | jq -r '.options[] | select(.name=="Done") | .id')
echo "released: $released_status_id"

# default limit 30 だと網羅できないので余裕のある数値にしておく
items=$(gh project item-list $project_number --owner tick-taku -L 100 --format json -q '.items.[] | select(.status=="Todo") | .id')
for item in ${items[@]}; do
  echo "item: $item"
  gh project item-edit --project-id $project --id $item --field-id $status_id --single-select-option-id $released_status_id
done
