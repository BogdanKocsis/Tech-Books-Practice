CREATE TEMPORARY TABLE A (
    val CHAR(1)
);

CREATE TEMPORARY TABLE B (
    val CHAR(1)
);

INSERT INTO A (val)
VALUES ('L'), ('M'), ('N'), ('O'), ('P');

-- Setul B = {P, Q, R, S, T}
INSERT INTO B (val)
VALUES ('P'), ('Q'), ('R'), ('S'), ('T');

-- ==========================
-- A UNION B
-- ==========================

SELECT val FROM A
UNION
SELECT val FROM B;

-- ==========================
-- A UNION ALL B
-- ==========================

SELECT val FROM A
UNION ALL
SELECT val FROM B;

-- ==========================
-- A INTERSECT B
-- ==========================

SELECT val FROM A
INTERSECT
SELECT val FROM B;

-- ==========================
-- A EXCEPT B
-- ==========================

SELECT val FROM A
EXCEPT
SELECT val FROM B;
