SELECT a.actor_id, t.level
FROM (
    SELECT actor_id, COUNT(*) AS n_roles
    FROM film_actor
    GROUP BY actor_id
) AS a
INNER JOIN (
    SELECT 'Superstar' AS level, 30 AS min_roles, 99999 AS max_roles
    UNION ALL
    SELECT 'Star' AS level, 20 AS min_roles, 29 AS max_roles
    UNION ALL
    SELECT 'Supporting Actor' AS level, 1 AS min_roles, 19 AS max_roles
) AS t
ON a.n_roles BETWEEN t.min_roles AND t.max_roles;