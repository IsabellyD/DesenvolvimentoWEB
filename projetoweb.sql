SELECT * FROM estudante;
SELECT * FROM disciplina;
SELECT * FROM disciplina_estudante;
SELECT 
    e.nome AS estudante,
    d.nome AS disciplina
FROM disciplina_estudante de
JOIN estudante e 
    ON e.id = de.estudante_id
JOIN disciplina d 
    ON d.id = de.disciplina_id;
