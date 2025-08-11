package com.example.houses;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        String logoUrl = "https://www.cognizant.com/us/media_1808da395be9f77c0124de824530b0338915414a8.svg?width=2000&format=webply&optimize=medium";
        return "<html>" +
            "<head><title>Vibe Coding Project 2025</title>" +
            "<meta name='viewport' content='width=device-width,initial-scale=1'/>" +
            "<link rel='icon' href='" + logoUrl + "'/>" +
            "<style>" +
            "body{font-family:'Segoe UI',Arial,sans-serif;min-height:100vh;margin:0;padding:0;overflow-x:hidden;" +
            "background: linear-gradient(-45deg, #0057b7, #3eb6e7, #0057b7, #3eb6e7);" +
            "background-size: 400% 400%;" +
            "animation: gradientBG 16s ease-in-out infinite;" +
            "}" +
            "@keyframes gradientBG {" +
            "0% {background-position:0% 50%;} " +
            "50% {background-position:100% 50%;} " +
            "100% {background-position:0% 50%;}" +
            "}" +
            ".container{position:relative;z-index:1;max-width:640px;background:#fff;border-radius:18px;box-shadow:0 8px 36px #0057b722;margin:3em auto 2em auto;padding:2.2em;}" +
            ".logo-block{display:flex;justify-content:center;margin-bottom:16px;}" +
            ".logo-img{height:60px;padding:12px 32px;background:#fff;border-radius:14px;box-shadow:0 2px 12px #0057b722;}" +
            ".title-block{text-align:center;margin-bottom:18px;}" +
            ".title{font-size:2.2em;font-weight:700;color:#0033a0;letter-spacing:1px;}" +
            // ... rest of your CSS ...
            "</style>" +
            // ... JS and HTML ...
            "<body>" +
            "<div class='container'>" +
            "<div class='logo-block'><img class='logo-img' src='" + logoUrl + "' alt='Cognizant Logo'/></div>" +
            "<div class='title-block'><span class='title'>Vibe Coding Project 2025</span></div>" +
            // ... rest of your markup ...
            "</div></body></html>";
    }
}