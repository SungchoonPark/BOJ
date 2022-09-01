-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME = 'Ella' || NAME = 'Lucy' || NAME = 'Pickle' || NAME = 'Rogan' || NAME = 'Sabrina' || NAME = 'Mitty'
ORDER BY ANIMAL_ID;