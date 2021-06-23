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


-- 일별 누적 접속자 통게 구하기

CREATE TABLE t
AS
SELECT '20150801' dt, 1 id FROM dual
UNION ALL SELECT '20150801', 2 FROM dual
UNION ALL SELECT '20150801', 1 FROM dual
UNION ALL SELECT '20150802', 1 FROM dual
UNION ALL SELECT '20150802', 2 FROM dual
UNION ALL SELECT '20150802', 2 FROM dual
UNION ALL SELECT '20150803', 3 FROM dual
UNION ALL SELECT '20150804', 4 FROM dual
UNION ALL SELECT '20150804', 1 FROM dual
UNION ALL SELECT '20150805', 1 FROM dual;

 

SELECT dt 
     , all_cnt AS 접속건수
     , id_cnt AS 접속자수
     , sum(all_cnt) OVER(ORDER BY dt) AS 누적접속건수
     , (SELECT count(DISTINCT(id)) FROM t WHERE t.dt <= a.dt) AS 누적접속자수
  FROM (
    SELECT dt , count(*) AS all_cnt , count(DISTINCT id) AS id_cnt
      FROM t
     GROUP BY dt
     ORDER BY dt
  )a


-- 공통점이 가장 많은 친구 찾기
  
  SELECT A.NM
       , A.C1 , A.C2, A.C3 , A.C4
    FROM t A
    LEFT OUTER JOIN T UNPIVOT 
         (C FOR T IN (C1,C2,C3,C4)) B
      ON B.NM != A.NM 
     AND B.C IN (A.C1,A.C2,A.C3,A.C4)