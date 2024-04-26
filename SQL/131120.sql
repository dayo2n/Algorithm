SELECT MEMBER_ID, 
       MEMBER_NAME, 
       GENDER, 
       TO_CHAR(DATE_OF_BIRTH, 'YYYY-MM-DD') DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE EXTRACT(MONTH FROM DATE_OF_BIRTH) = 3 
      AND NOT TLNO IS NULL
      AND GENDER = 'W'
ORDER BY MEMBER_ID