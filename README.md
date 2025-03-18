# Gatling Performance Test Pipeline

Este repositorio contiene un pipeline automatizado configurado en GitHub Actions para ejecutar pruebas de rendimiento utilizando [Gatling](https://gatling.io/). Las pruebas evalúan el rendimiento de diferentes simulaciones de API en entornos abiertos y cerrados.

## Tabla de contenido

- [Características](#características)
- [Estructura del Pipeline](#estructura-del-pipeline)
- [Requisitos Previos](#requisitos-previos)
- [Cómo Usar](#cómo-usar)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Características

- Ejecución automatizada de pruebas de rendimiento al realizar un `push` o una `pull request` en la rama `main`.
- Integración con Gatling para probar múltiples simulaciones de API.
- Generación de reportes de rendimiento detallados.
- Almacenamiento de reportes como artefactos en las ejecuciones de GitHub Actions.

## Estructura del Pipeline

El pipeline consta de los siguientes pasos principales:
1. **Clonación del Repositorio:** Descarga el código fuente.
2. **Configuración de JDK 17:** Instala y configura Java para ejecutar Gatling.
3. **Instalación de Dependencias:** Descarga las dependencias necesarias utilizando Maven.
4. **Ejecución de Simulaciones:** Ejecuta las pruebas definidas en las simulaciones de Gatling.
5. **Generación de Reportes:** Genera reportes de rendimiento en el directorio `target/gatling`.
6. **Subida de Artefactos:** Sube los reportes como artefactos de GitHub Actions para fácil acceso.

## Requisitos Previos

Antes de usar este pipeline, asegúrate de contar con lo siguiente:
- Un repositorio en GitHub configurado con GitHub Actions.
- Gatling instalado y simulaciones definidas en tu código.
- Java 17 (o compatible) instalado.
- Maven configurado para manejar tus dependencias.

## Cómo Usar

1. **Clona este repositorio:**
   ```bash
   git clone https://github.com/baquerol/kata-automate-load-testing.git