CREATE VIEW film_category_actor (
    title,
    category_name,
    first_name,
    last_name
) AS
SELECT f.title, c.name AS category_name, a.first_name, a.last_name
FROM film AS f 
    INNER JOIN film_actor AS fa
    ON f.film_id = fa.film_id
    INNER JOIN actor AS a
    ON fa.actor_id = a.actor_id
    INNER JOIN film_category AS fc
    ON f.film_id = fc.film_id
    INNER JOIN category AS c
    ON fc.category_id = c.category_id;