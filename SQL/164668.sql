SELECT A.USER_ID, A.NICKNAME, B.TOTAL
FROM USED_GOODS_USER A, (SELECT WRITER_ID, SUM(PRICE) TOTAL
                         FROM USED_GOODS_BOARD
                         WHERE STATUS = 'DONE'
                         GROUP BY WRITER_ID) B
WHERE B.TOTAL >= 700000 AND A.USER_ID = B.WRITER_ID
ORDER BY B.TOTAL