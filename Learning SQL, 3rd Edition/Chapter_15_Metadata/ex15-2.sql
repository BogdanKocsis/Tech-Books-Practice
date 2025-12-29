WITH idx_info AS (
    SELECT
        il.name AS index_name,
        ii.name AS column_name,
        ii.seqno AS seq_in_index,
        il.tbl_name AS table_name,
        COUNT(*) OVER (PARTITION BY il.name) AS num_columns
    FROM
        pragma_index_list('customer') AS il
        JOIN pragma_index_info(il.name) AS ii ON il.name = ii.name
    WHERE
        il.origin != 'pk' -- Exclude primary key indexes
)
SELECT
    CASE
        WHEN seq_in_index = 0 THEN 'CREATE INDEX ' || index_name || ' ON ' || table_name || ' (' || column_name
        ELSE ', ' || column_name
    END ||
    CASE
        WHEN seq_in_index = num_columns - 1 THEN ');'
        ELSE ''
    END AS index_creation_statement
FROM
    idx_info
ORDER BY
    index_name,
    seq_in_index;