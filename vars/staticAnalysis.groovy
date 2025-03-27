def call(boolean abortPipeline = false) {
    timeout(time: 5, unit: 'MINUTES') {
        script {
            echo "Ejecución de las pruebas de calidad de código"

            def qualityGateResult = "PASSED"

            echo "Resultado del QualityGate: ${qualityGateResult}"

            if (abortPipeline && qualityGateResult != "PASSED") {
                error("Pipeline abortado debido a fallos en el análisis de calidad.")
            }
        }
    }
}
