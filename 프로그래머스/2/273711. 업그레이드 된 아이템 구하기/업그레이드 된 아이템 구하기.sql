-- 코드를 작성해주세요
select II.ITEM_ID AS ITEM_ID, II.ITEM_NAME AS ITEM_NAME, II.RARITY AS RARITY
FROM ITEM_INFO AS II
JOIN ITEM_TREE AS IT
ON II.ITEM_ID = IT.ITEM_ID
WHERE 
    IT.PARENT_ITEM_ID IN (
        SELECT ITEM_ID
        FROM ITEM_INFO
        WHERE RARITY = 'RARE'
    )
ORDER BY ITEM_ID DESC