-- 코드를 작성해주세요
select count(*) as FISH_COUNT
FROM FISH_INFO
WHERE LENGTH <= 10 OR LENGTH IS NULL