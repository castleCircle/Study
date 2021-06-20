Quiz1
-- 구분자로 나누어 행 , 열 바꾸기 

SELECT * FROM t;

SELECT REGEXP_SUBSTR(v,'[^|]+',1,1)
     , REGEXP_SUBSTR(v,'[^|]+',1,2)
     , REGEXP_SUBSTR(v,'[^|]+',1,3)
     , REGEXP_SUBSTR(v,'[^|]+',1,4)
  FROM t;
  

SELECT GB 
     , MIN(DECODE(NO,1,V)) AS "1"
     , MIN(DECODE(NO,2,V)) AS "2"
     , MIN(DECODE(NO,3,V)) AS "3"
     , MIN(DECODE(NO,4,V)) AS "4"
  FROM (
SELECT GB, NO , DECODE(GB,1,V1,2,V2,3,V3,4,V4) V 
  FROM ( 
SELECT NO
	 , SUBSTR(REGEXP_SUBSTR(v,'1:[^|]+'),3) V1
     , SUBSTR(REGEXP_SUBSTR(v,'2:[^|]+'),3) V2
     , SUBSTR(REGEXP_SUBSTR(v,'3:[^|]+'),3) V3
     , SUBSTR(REGEXP_SUBSTR(v,'4:[^|]+'),3) V4
  FROM t),
   (SELECT LEVEL GB FROM DUAL CONNECT BY LEVEL <= 4)
)GROUP BY GB
 
  
  SELECT
    GB,
    MIN(DECODE(NO,1,V)) AS "1",
    MIN(DECODE(NO,2,V)) AS "2",
    MIN(DECODE(NO,3,V)) AS "3",
    MIN(DECODE(NO,4,V)) AS "4"
FROM (
    SELECT
        NO,
        GB,
        DECODE(GB,1,V1,2,V2,3,V3,4,V4) V
    FROM
        (SELECT
            NO,
            SUBSTR(REGEXP_SUBSTR(V,'1:[^|]+'),3) V1,
            SUBSTR(REGEXP_SUBSTR(V,'2:[^|]+'),3) V2,
            SUBSTR(REGEXP_SUBSTR(V,'3:[^|]+'),3) V3,
            SUBSTR(REGEXP_SUBSTR(V,'4:[^|]+'),3) V4
        FROM T),
        (SELECT LEVEL GB FROM DUAL CONNECT BY LEVEL <= 4)
     )
GROUP BY GB;