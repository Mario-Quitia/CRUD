// Seleccionar elementos del DOM
const cloud = document.getElementById("cloud");
const barraLateral = document.querySelector(".barra_lateral");
const spans = document.querySelectorAll("span");
const palanca = document.querySelector(".switch");
const circulo = document.querySelector(".circulo");

// Modo Oscuro
palanca.addEventListener("click", () => {
  let body = document.body;
  body.classList.toggle("dark-mode");
  circulo.classList.toggle("prendido");
});

// Minimizar barra lateral
cloud.addEventListener("click", () => {
  barraLateral.classList.toggle("mini-barra-lateral");
  spans.forEach((span) => {
    span.classList.toggle("oculto");
  });
});

// Mostrar contenedor específico y ocultar los demás
function mostrarContenedor(id) {
  // Ocultar todos los contenedores
  const contenedores = document.querySelectorAll(".contenedor");
  console.log(contenedores);
  contenedores.forEach(function (contenedor) {
    contenedor.style.display = "none";
  });

  // Mostrar el contenedor seleccionado
  const contenedorSeleccionado = document.getElementById(id);
  console.log(contenedorSeleccionado);
  if (contenedorSeleccionado) {
    contenedorSeleccionado.style.display = "block";
  }
}

// Mostrar un contenedor por defecto al cargar la página
document.addEventListener("DOMContentLoaded", function () {
  let urlActual = document.URL;
  
  urlActual = urlActual.slice(22);
  
  if (urlActual === "listar") {
    mostrarContenedor("contenedor-productos");
  } else if (urlActual === "listarClientes") {
    mostrarContenedor("contenedor-clientes");
  }

});
