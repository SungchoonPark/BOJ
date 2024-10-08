-- 코드를 작성해주세요
select 
    ROUTE, 
    CONCAT(ROUND(SUM(D_BETWEEN_DIST), 1), 'km') AS TOTAL_DISTANCE, 
    CONCAT(ROUND(SUM(D_BETWEEN_DIST) / COUNT(*), 2), 'km') AS AVERAGE_DISTANCE
from SUBWAY_DISTANCE
group by ROUTE
ORDER BY ROUND(SUM(D_BETWEEN_DIST), 1) DESC;