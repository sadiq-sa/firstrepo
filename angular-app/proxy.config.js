const PROXY_CONFIG = [
    {
        context: [
            "/api/auth",
            "/api/test",
            "/petfinder",
        ],
        target: "http://localhost:8081",
        secure: false
    }
]

module.exports = PROXY_CONFIG;