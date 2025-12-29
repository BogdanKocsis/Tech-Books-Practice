SELECT f.title
FROM film AS f
    WHERE f.film_id IN (
        SELECT fc.film_id
        FROM category AS c
            INNER JOIN film_category AS fc
            ON fc.category_id = c.category_id
        WHERE c.name = 'Action'
    );