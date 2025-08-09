package com.example.houses;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        return "<html>" +
                "<head><title>Welcome to Vibe Coding Project 2025!</title>" +
                "<style>" +
                "body{font-family:sans-serif;background:linear-gradient(135deg,#e0c3fc 0%,#8ec5fc 100%);padding:2em;text-align:center;}" +
                "h1{font-size:2.5em;color:#333;margin-bottom:0.5em;}" +
                "p{font-size:1.2em;color:#444;}" +
                "a{display:inline-block;margin:1em 0;padding:0.75em 1.5em;border-radius:8px;background:#5e60ce;color:#fff;text-decoration:none;font-weight:bold;font-size:1.1em;transition:background 0.2s;}" +
                "a:hover{background:#3f37c9;}" +
                ".emoji{font-size:2em;}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='emoji'>🏠✨</div>" +
                "<h1>Welcome to Vibe Coding Project 2025!</h1>" +
                "<p>Ready to explore real estate like never before?<br>Click the button below to view the <strong>Cheapest Houses</strong> app:</p>" +
                "<a href='https://cts-vibeappce21201-4.azurewebsites.net/api/houses/cheapest' target='_blank'>🏠 Launch Cheapest Houses App</a>" +
                "<p>Want to see the source code or contribute?<br>Visit our GitHub repo:</p>" +
                "<a href='https://github.com/edecampos/Vibe-Coding' target='_blank'>💻 Vibe Coding GitHub Repo</a>" +
                "<p style='margin-top:2em;color:#6a4c93;'>Made with ❤️ for the 2025 Coding Challenge!</p>" +
                "</body></html>";
    }
}