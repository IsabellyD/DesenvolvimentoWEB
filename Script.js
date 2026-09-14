function validarCadastro() {
    const confirmar = confirm(
        "Deseja realmente salvar os dados desta disciplina?"
    );

    if (confirmar) {
        const nome = document.getElementById("nomeDisciplina").value;
        const professor = document.getElementById("professor").value;
        const cargaHoraria = document.getElementById("cargaHoraria").value;

        let disciplinas = JSON.parse(
            localStorage.getItem("disciplinas")
        ) || [];

        const novoId = disciplinas.length > 0
            ? Math.max(...disciplinas.map(disciplina => disciplina.id)) + 1
            : 1;

        const disciplina = {
            id: novoId,
            nome: nome,
            professor: professor,
            cargaHoraria: cargaHoraria
        };

        disciplinas.push(disciplina);

        localStorage.setItem(
            "disciplinas",
            JSON.stringify(disciplinas)
        );

        alert("Disciplina salva com sucesso!");

        document.getElementById("formDisciplina").reset();
    } else {
        alert("Cadastro cancelado.");
    }
}


function cadastrarEstudante() {
    const nome = document.getElementById("nomeEstudante").value;
    const idade = document.getElementById("idadeEstudante").value;
    const email = document.getElementById("emailEstudante").value;

    let estudantes = JSON.parse(
        localStorage.getItem("estudantes")
    ) || [];

    const novoId = estudantes.length > 0
        ? Math.max(...estudantes.map(estudante => estudante.id)) + 1
        : 1;

    const estudante = {
        id: novoId,
        nome: nome,
        idade: idade,
        email: email
    };

    estudantes.push(estudante);

    localStorage.setItem(
        "estudantes",
        JSON.stringify(estudantes)
    );

    alert("Estudante salvo com sucesso!");

    document.getElementById("formEstudante").reset();
}


function carregarDisciplinas() {
    const tabela = document.getElementById("tabelaDisciplinas");

    if (!tabela) {
        return;
    }

    const disciplinas = JSON.parse(
        localStorage.getItem("disciplinas")
    ) || [];

    tabela.innerHTML = "";

    disciplinas.forEach(disciplina => {
        const linha = document.createElement("tr");

        linha.innerHTML = `
            <td>${disciplina.id}</td>
            <td>${disciplina.nome}</td>
            <td>${disciplina.professor}</td>
            <td>${disciplina.cargaHoraria}</td>
        `;

        tabela.appendChild(linha);
    });
}


function carregarEstudantes() {
    const tabela = document.getElementById("tabelaEstudantes");

    if (!tabela) {
        return;
    }

    const estudantes = JSON.parse(
        localStorage.getItem("estudantes")
    ) || [];

    tabela.innerHTML = "";

    estudantes.forEach(estudante => {
        const linha = document.createElement("tr");

        linha.innerHTML = `
            <td>${estudante.id}</td>
            <td>${estudante.nome}</td>
            <td>${estudante.idade}</td>
            <td>${estudante.email}</td>
        `;

        tabela.appendChild(linha);
    });
}

function avaliarMeta() {
    const resposta = prompt(
        "Quantas horas por semana você pretende dedicar às disciplinas?"
    );

    const horas = parseInt(resposta);

    if (horas >= 10) {
        alert(
            "Excelente meta! Você terá um ótimo rendimento."
        );
    } else {
        alert(
            "Cuidado! Pode ser necessário dedicar mais tempo aos estudos."
        );
    }
}

document.addEventListener("DOMContentLoaded", function () {
    carregarDisciplinas();
    carregarEstudantes();
});
