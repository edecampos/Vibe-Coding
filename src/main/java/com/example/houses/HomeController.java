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
            "background: linear-gradient(-45deg, #0057b7, #3eb6e7, #00c48c, #b825f2);" + // More colors!
            "background-size: 600% 600%;" +
            "animation: gradientBG 8s ease-in-out infinite;}" +     // Faster animation!
            "@keyframes gradientBG {" +
            "0% {background-position:0% 50%;} " +
            "50% {background-position:100% 50%;} " +
            "100% {background-position:0% 50%;}" +
            "}" +
            ".container{position:relative;z-index:1;max-width:840px;background:#fff;border-radius:28px;box-shadow:0 12px 48px #0057b722;margin:3em auto 2em auto;padding:2.3em 2em;" +
            "border: 7px solid rgba(0,87,183,0.08);}" + // Add a semi-transparent border to let animation show
            ".logo-block{display:flex;justify-content:center;margin-bottom:16px;}" +
            ".logo-img{height:72px;padding:18px 44px;background:#fff;border-radius:18px;box-shadow:0 2px 18px #0057b722;}" +
            ".title-block{text-align:center;margin-bottom:24px;}" +
            ".title{font-size:2.4em;font-weight:700;color:#0033a0;letter-spacing:1px;}" +
            ".notice{background:#e6f0fa;color:#0057b7;border-left:7px solid #3eb6e7;" +
            "box-shadow:0 2px 10px #0057b710;padding:1em 1.5em;margin-bottom:2em;border-radius:16px;" +
            "font-size:1.22em;display:flex;align-items:center;gap:14px;}" +
            ".notice .icon{font-size:1.65em;vertical-align:middle;}" +
            ".notice strong{color:#0033a0;}" +
            ".progressbar{display:flex;justify-content:space-between;align-items:center;margin-bottom:2em;position:relative;height:62px;}" +
            ".progressstep{flex:1;text-align:center;position:relative;z-index:1;}" +
            ".progresscircle{width:48px;height:48px;background:#e6f0fa;border-radius:50%;display:inline-block;line-height:48px;font-weight:700;color:#0057b7;font-size:1.3em;box-shadow:0 2px 10px #0057b710;transition:background .3s, color .3s;position:relative;top:0;}" +
            ".progressstep.active .progresscircle{background:linear-gradient(90deg,#0057b7 0%,#3eb6e7 100%);color:#fff;box-shadow:0 4px 16px #0057b722;}" +
            ".progresslabel{margin-top:8px;font-size:1.1em;color:#0057b7;font-weight:600;}" +
            ".progressbar .bar{position:absolute;top:23px;left:7%;width:86%;height:8px;background:#e6f0fa;z-index:0;border-radius:4px;}" +
            ".progressbar .bar-active{position:absolute;top:23px;left:7%;height:8px;background:linear-gradient(90deg,#0057b7 0%,#3eb6e7 100%);z-index:0;border-radius:4px;transition:width .5s;}" +
            ".step{display:none;}" +
            ".step.active{display:block;animation:fadein .5s;}" +
            "@keyframes fadein{0%{opacity:0;transform:translateY(20px);}100%{opacity:1;transform:translateY(0);}}" +
            "label{display:block;margin:1em 0 0.3em 0;font-weight:600;color:#0033a0;font-size:1.07em;}" +
            "input[type=text], input[type=number]{width:97%;padding:0.8em;margin-bottom:1.3em;border:1px solid #d1dbe6;border-radius:9px;font-size:1.08em;background:#f7fbfd;}" +
            "button{background:linear-gradient(90deg,#0057b7 0%,#3eb6e7 100%);color:#fff;padding:0.8em 2.3em;border:none;border-radius:9px;font-size:1.12em;font-weight:bold;cursor:pointer;box-shadow:0 2px 10px #0057b710;transition:filter 0.18s;}" +
            "button:hover{filter:brightness(1.08);}" +
            ".resultsSection{display:none;margin-top:2em;animation:fadein .7s;}" +
            ".resultsSection.active{display:block;}" +
            ".resultsTitle{font-size:1.3em;font-weight:700;color:#0057b7;margin-bottom:.6em;}" +
            ".resultsList{background:#eef6fc;border-radius:12px;padding:1.2em 1.5em;font-size:1.04em;color:#223;box-shadow:0 2px 8px #0057b722;margin-bottom:1.7em;line-height:1.7;}" +
            ".summary{background:#eef6fb;color:#0057b7;padding:1em 1.5em;border-radius:10px;margin-bottom:1em;font-size:1.09em;}" +
            ".repo-link{display:inline-block;margin-top:2em;padding:0.65em 1.5em;background:#0057b7;color:#fff;border-radius:8px;text-decoration:none;font-weight:500;box-shadow:0 2px 10px #0057b788;transition:background 0.2s;}" +
            ".repo-link:hover{background:#0033a0;}" +
            ".footer{margin-top:2em;text-align:center;color:#0057b7;}" +
            ".footer strong{color:#0033a0;}" +
            "</style>" +

            "<script>" +
            "function updateProgressBar(step) {" +
            "  var bar = document.getElementById('progressActiveBar');" +
            "  var widths = ['0%', '49%', '98%'];" +
            "  bar.style.width = widths[step-1];" +
            "}" +

            "function showStep(step) {" +
            "  for(var i=1;i<=3;i++){" +
            "    document.getElementById('step'+i).classList.remove('active');" +
            "    document.getElementById('pb'+i).classList.remove('active');" +
            "  }" +
            "  document.getElementById('step'+step).classList.add('active');" +
            "  document.getElementById('pb'+step).classList.add('active');" +
            "  updateProgressBar(step);" +
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
            "  document.getElementById('resultsSection').classList.add('active');" +
            "  setTimeout(function(){" +
            "    document.getElementById('resultsSection').scrollIntoView({behavior:'smooth',block:'start'});" +
            "  }, 350);" +
            "}" +
            "window.onload = function() { showStep(1); };" +
            "</script>" +

            "</head>" +
            "<body>" +
            "<div class='container'>" +
            "<div class='logo-block'><img class='logo-img' src='" + logoUrl + "' alt='Cognizant Logo'/></div>" +
            "<div class='title-block'><span class='title'>Vibe Coding Project 2025</span></div>" +
            "<div class='notice'><span class='icon'>ℹ️</span> <span>Please complete <strong>all fields below</strong> to search for the <strong>Top 10 Cheapest Houses per Square Foot</strong>. Both Address and Radius are <strong>mandatory</strong>.</span></div>" +
            "<div style='text-align:center;font-size:1.18em;color:#4a5a6a;margin-bottom:1em;'>Find the best value homes near you.<br>Follow the three steps below!</div>" +
            "<div class='progressbar'>" +
                "<div class='bar'></div>" +
                "<div id='progressActiveBar' class='bar-active' style='width:0%;'></div>" +
                "<div class='progressstep active' id='pb1'><span class='progresscircle'>1</span><div class='progresslabel'>Address</div></div>" +
                "<div class='progressstep' id='pb2'><span class='progresscircle'>2</span><div class='progresslabel'>Radius</div></div>" +
                "<div class='progressstep' id='pb3'><span class='progresscircle'>3</span><div class='progresslabel'>Review</div></div>" +
            "</div>" +
            "<div id='step1' class='step active'>" +
            "<label for='address'>Step 1: <strong>Enter Address, State, Zip Code</strong></label>" +
            "<input type='text' id='address' placeholder='e.g. 123 Main St, City, ST 12345' autocomplete='street-address' required />" +
            "<button type='button' onclick='nextStep1()'>Next &rarr;</button>" +
            "</div>" +
            "<div id='step2' class='step'>" +
            "<label for='radius'>Step 2: <strong>Enter Radius (miles)</strong></label>" +
            "<input type='number' id='radius' min='1' max='500' value='100' required />" +
            "<button type='button' onclick='nextStep2()'>Next &rarr;</button>" +
            "</div>" +
            "<div id='step3' class='step'>" +
            "<div class='summary'>" +
            "<strong>Review Your Criteria:</strong><br>" +
            "Address: <span id='summaryAddress'></span><br>" +
            "Radius: <span id='summaryRadius'></span> miles" +
            "</div>" +
            "<button type='button' onclick='submitCheapest()'>View Top 10 Cheapest Houses</button>" +
            "</div>" +
            "<div id='resultsSection' class='resultsSection'>" +
            "<div class='resultsTitle'>Top 10 Cheapest Houses per Sq. Foot</div>" +
            "<iframe id='resultsFrame'></iframe>" +
            "</div>" +
            "<a class='repo-link' href='https://github.com/edecampos/Vibe-Coding' target='_blank'>💻 View GitHub Repository</a>" +
            "<div class='footer'><strong>Made for the 2025 Coding Challenge</strong> &mdash; Powered by Cognizant</div>" +
            "</div>" +
            "</body></html>";
    }
}