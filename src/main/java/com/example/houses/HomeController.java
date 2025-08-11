package com.example.houses;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        // Use your working Cognizant logo SVG
        String logoUrl = "https://www.cognizant.com/us/media_1808da395be9f77c0124de824530b0338915414a8.svg?width=2000&format=webply&optimize=medium";

        return "<html>" +
            "<head><title>Vibe Coding Project 2025</title>" +
            "<meta name='viewport' content='width=device-width,initial-scale=1'/>" +
            "<link rel='icon' href='" + logoUrl + "'/>" +
            "<style>" +
            // --- Animated gradient background
            "body{font-family:'Segoe UI',Arial,sans-serif;" +
            "min-height:100vh;margin:0;padding:0;overflow-x:hidden;" +
            "background: linear-gradient(-45deg, #0057b7, #3eb6e7, #0057b7, #3eb6e7);" +
            "background-size: 400% 400%;" +
            "animation: gradientBG 16s ease-in-out infinite;" +
            "position:relative;}" +
            "@keyframes gradientBG {" +
            " 0% {background-position:0% 50%;} " +
            " 50% {background-position:100% 50%;} " +
            " 100% {background-position:0% 50%;}" +
            "}" +
            // --- Watermark logo in background
            "body::before{" +
            "content:'';" +
            "position:fixed;" +
            "z-index:0;" +
            "top:55%;left:50%;" +
            "transform:translate(-50%,-50%);" +
            "background:url('" + logoUrl + "') no-repeat center center;" +
            "opacity:0.10;" +
            "background-size:700px;" +
            "width:700px;height:200px;" +
            "pointer-events:none;" +
            "}" +

            ".container{position:relative;z-index:1;max-width:640px;background:#fff;border-radius:18px;box-shadow:0 8px 36px #0057b722;margin:3em auto 2em auto;padding:2.2em;}" +
            ".logo-row{display:flex;align-items:center;justify-content:center;margin-bottom:1.3em;}" +
            ".logo-img{height:48px;margin-right:20px;background:#fff;border-radius:8px;box-shadow:0 2px 8px #0057b710;}" +
            ".title{font-size:2em;font-weight:700;color:#0033a0;text-align:left;}" +
            ".notice{background:#e6f0fa;color:#0057b7;border-left:
