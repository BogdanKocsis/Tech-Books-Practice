SELECT DISTINCT table_name, index_name
FROM information_schema.statistics
WHERE table_schema = 'sakila';