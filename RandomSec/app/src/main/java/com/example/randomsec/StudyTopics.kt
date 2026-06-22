package com.example.randomsec

object StudyTopics {
    val topics = listOf(
        "Redes de Computadores",
        "Forense Digital",
        "Criptografia",
        "Segurança de Redes",
        "Análise de Malware",
        "Testes de Penetração",
        "Engenharia Social",
        "Segurança em Nuvem",
        "Segurança IoT",
        "Blockchain e Criptomoedas",
        "Firewalls e IDS/IPS",
        "Gestão de Identidade",
        "Resposta a Incidentes",
        "Segurança de Aplicações",
        "Governança e Compliance"
    )

    val subtopics = mapOf(
        "Redes de Computadores" to listOf("TCP/IP", "DNS", "Roteamento", "Sub-redes", "Protocolos"),
        "Forense Digital" to listOf("Aquisição de Dados", "Análise de Disco", "Recuperação de Arquivos", "Logs", "Evidências"),
        "Criptografia" to listOf("Cifras Simétricas", "Cifras Assimétricas", "Hash", "Certificados", "PKI"),
        "Segurança de Redes" to listOf("VPN", "Firewall", "IDS/IPS", "Segmentação", "Zonas DMZ"),
        "Análise de Malware" to listOf("Engenharia Reversa", "Sandbox", "Assinaturas", "Comportamento", "Classificação"),
        "Testes de Penetração" to listOf("Reconhecimento", "Escaneamento", "Exploração", "Pós-exploração", "Relatório"),
        "Engenharia Social" to listOf("Phishing", "Pretexting", "Baiting", "Tailgating", "Estratégias"),
        "Segurança em Nuvem" to listOf("IAM", "Criptografia em Nuvem", "Compliance", "Container Security", "Serverless"),
        "Segurança IoT" to listOf("Dispositivos Embarcados", "Comunicação", "Firmware", "Protocolos", "Atualizações"),
        "Blockchain e Criptomoedas" to listOf("Consenso", "Smart Contracts", "Wallets", "Mineradoras", "Segurança"),
        "Firewalls e IDS/IPS" to listOf("Regras", "Filtragem", "Inspeção", "Detecção", "Prevenção"),
        "Gestão de Identidade" to listOf("Autenticação", "Autorização", "SSO", "MFA", "Diretórios"),
        "Resposta a Incidentes" to listOf("Preparação", "Detecção", "Contenção", "Eradicação", "Recuperação"),
        "Segurança de Aplicações" to listOf("OWASP", "SAST", "DAST", "Secure Coding", "SDLC"),
        "Governança e Compliance" to listOf("LGPD", "GDPR", "ISO 27001", "Políticas", "Auditoria")
    )
}