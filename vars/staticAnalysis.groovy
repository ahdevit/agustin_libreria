def call(boolean abortPipeline = false) {
    timeout(time: 5, unit: 'MINUTES') {
        script {
            echo "Ejecución de las pruebas de calidad de código"
            def branchName = env.BRANCH_NAME ?: 'unknown'
            echo "Nombre de la rama: ${branchName}"
            def qualityGateResult = "PASSED"
            if (abortPipeline || branchName == 'master' || branchName.startsWith('hotfix')) {
                if (qualityGateResult != "PASSED") {
                    error("Pipeline abortado debido a fallos en el análisis de calidad en la rama ${branchName}.")
                }
            } else {
                echo "Pipeline continúa aunque el análisis haya fallado (Rama: ${branchName})."
            }
        }
    }
}


