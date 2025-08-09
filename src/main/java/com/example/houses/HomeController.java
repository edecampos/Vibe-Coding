package com.example.houses;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        // Reliable Cognizant Logo PNG (public CDN)
        String logoUrl = "https://upload.wikimedia.org/wikipedia/commons/6/6e/Cognizant_logo.svg";
        // Watermark logo (SVG, can be made very large and faint)
        String watermarkLogo = "https://upload.wikimedia.org/wikipedia/commons/6/6e/Cognizant_logo.svg";

        return "<html>" +
            "<head><title>Welcome to Vibe Coding Project 2025!</title>" +
            "<meta name='viewport' content='width=device-width,initial-scale=1'/>" +
            "<link rel='icon' href='" + logoUrl + "'/>" +
            "<style>" +
            // Background with watermark logo
            "body{font-family:Segoe UI,Arial,sans-serif;" +
            "background:linear-gradient(120deg,#0057b7 0%,#3eb6e7 100%);" +
            "margin:0;padding:0;min-height:100vh;}" +
            "body::before{" +
            "content:'';position:fixed;z-index:0;top:50%;left:50%;transform:translate(-50%,-50%);" +
            "background:url('" + watermarkLogo + "') no-repeat center center;opacity:0.08;" +
            "background-size:900px;" +
            "width:900px;height:280px;pointer-events:none;}" +
            ".container{position:relative;z-index:1;max-width:640px;background:#fff;border-radius:18px;box-shadow:0 8px 36px #0057b722;margin:3em auto 1.7em auto;padding:2.2em 2.2em 2.2em 2.2em;}" +

            ".logo-row{display:flex;align-items:center;justify-content:center;margin-bottom:1.1em;}" +
            ".logo-img{height:48px;margin-right:18px;box-shadow:0 2px 8px #0057b710;border-radius:8px;background:#fff;}" +
            ".title{font-size:2.1em;font-weight:700;color:#0033a0;margin-bottom:0.1em;text-align:left;}" +

            ".notice{background:#e6f0fa;color:#0057b7;border-left:7px solid #3eb6e7;box-shadow:0 2px 10px #0057b710;padding:1em 1.5em;margin-bottom:2em;border-radius:10px;font-size:1.11em;display:flex;align-items:center;gap:14px;}" +
            ".notice .icon{font-size:1.65em;vertical-align:middle;}" +
            ".notice strong{color:#0033a0;}" +

            ".steps-bar{display:flex;justify-content:space-between;gap:18px;margin-bottom:2.2em;}" +
            ".step-card{flex:1;background:#f4f8fb;border-radius:12px;padding:1em 0.4em;text-align:center;font-size:1.06em;color:#0057b7;font-weight:600;box-shadow:0 2px 8px #0057b710;}" +

            ".step{display:none;}" +
            ".step.active{display:block;}" +
            "label{display:block;margin:1em 0 0.2em 0;font-weight:600;color:#0033a0;}" +
            "input[type=text], input[type=number]{width:97%;padding:0.7em;margin-bottom:1.2em;border:1px solid #d1dbe6;border-radius:8px;font-size:1em;background:#f7fbfd;}" +
            "button{background:linear-gradient(90deg,#0057b7 0%,#3eb6e7 100%);color:#fff;padding:0.7em 2.2em;border:none;border-radius:8px;font-size:1.07em;font-weight:bold;cursor:pointer;box-shadow:0 2px 8px #0057b710;transition:filter 0.18s;}" +
            "button:hover{filter:brightness(1.08);}" +
            "#resultsFrame{width:100%;max-width:900px;height:480px;border:none;box-shadow:0 2px 10px #0033a055;margin:2em auto;display:none;border-radius:12px;background:#f4f8fb;}" +
            ".summary{background:#eef6fb;color:#0057b7;padding:1em 1.5em;border-radius:10px;margin-bottom:1em;font-size:1.05em;}" +

            ".repo-link{display:inline-block;margin-top:2em;padding:0.65em 1.5em;background:#0057b7;color:#fff;border-radius:8px;text-decoration:none;font-weight:500;box-shadow:0 2px 10px #0057b788;transition:background 0.2s;}" +
            ".repo-link:hover{background:#0033a0;}" +
            ".footer{margin-top:2em;text-align:center;color:#0057b7;}" +
            ".footer strong{color:#0033a0;}" +
            "</style>" +
            "<script>" +
            "function showStep(step) {" +
            "  document.getElementById('step1').classList.remove('active');" +
            "  document.getElementById('step2').classList.remove('active');" +
            "  document.getElementById('step3').classList.remove('active');" +
            "  document.getElementById('step'+step).classList.add('active');" +
            "}" +
            "function nextStep1() {" +
            "  var address = document.getElementById('address').value.trim();" +
            "  if(address === '') {" +
            "    alert('Please enter Address, State, Zip Code'); return;" +
            "  }" +
            "  showStep(2);" +
            "}" +
            "function nextStep2() {" +
            "  var radius = document.getElementById('radius').value.trim();" +
            "  if(radius === '' || isNaN(radius) || radius <= 0) {" +
            "    alert('Please enter a valid radius'); return;" +
            "  }" +
            "  showStep(3);" +
            "  document.getElementById('summaryAddress').innerText = document.getElementById('address').value;" +
            "  document.getElementById('summaryRadius').innerText = document.getElementById('radius').value;" +
            "}" +
            "function submitCheapest() {" +
            "  var address = encodeURIComponent(document.getElementById('address').value);" +
            "  var radius = encodeURIComponent(document.getElementById('radius').value);" +
            "  var iframe = document.getElementById('resultsFrame');" +
            "  iframe.src = '/api/houses/cheapest?address=' + address + '&radius=' + radius;" +
            "  iframe.style.display = 'block';" +
            "}" +
            "window.onload = function() { showStep(1); };" +
            "</script>" +
            "</head>" +
            "<body>" +
            "<div class='container'>" +

            "<div class='logo-row'>" +
            "<img class='logo-img' src='" + logoUrl + "' alt='Cognizant'/>" +
            "<span class='title'>Vibe Coding Project 2025</span>" +
            "</div>" +

            "<div class='notice'><span class='icon'>ℹ️</span> <span>Please complete <strong>all fields below</strong> to search for the <strong>Top 10 Cheapest Houses per Square Foot</strong>. Both Address and Radius are <strong>mandatory</strong>.</span></div>" +

            "<div style='text-align:center;font-size:1.13em;color:#4a5a6a;margin-bottom:1em;'>Find the best value homes near you.<br>Follow the three steps below!</div>" +

            "<div class='steps-bar'>" +
            "<div class='step-card'>1. Enter Address</div>" +
            "<div class='step-card'>2. Enter Radius</div>" +
            "<div class='step-card'>3. Review & Search</div>" +
            "</div>" +

            // Step 1: Address
            "<div id='step1' class='step active'>" +
            "<label for='address'>Step 1: <strong>Enter Address, State, Zip Code</strong></label>" +
            "<input type='text' id='address' placeholder='e.g. 123 Main St, City, ST 12345' autocomplete='street-address' required />" +
            "<button type='button' onclick='nextStep1()'>Next &rarr;</button>" +
            "</div>" +

            // Step 2: Radius
            "<div id='step2' class='step'>" +
            "<label for='radius'>Step 2: <strong>Enter Radius (miles)</strong></label>" +
            "<input type='number' id='radius' min='1' max='500' value='100' required />" +
            "<button type='button' onclick='nextStep2()'>Next &rarr;</button>" +
            "</div>" +

            // Step 3: Summary and Submit
            "<div id='step3' class='step'>" +
            "<div class='summary'>" +
            "<strong>Review Your Criteria:</strong><br>" +
            "Address: <span id='summaryAddress'></span><br>" +
            "Radius: <span id='summaryRadius'></span> miles" +
            "</div>" +
            "<button type='button' onclick='submitCheapest()'>View Top 10 Cheapest Houses</button>" +
            "</div>" +

            // Results iframe
            "<iframe id='resultsFrame'></iframe>" +

            "<a class='repo-link' href='https://github.com/edecampos/Vibe-Coding' target='_blank'>💻 View GitHub Repository</a>" +

            "<div class='footer'><strong>Made for the 2025 Coding Challenge</strong> &mdash; Powered by Cognizant</div>" +
            "</div>" +
            "</body></html>";
    }
}