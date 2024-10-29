async function shortenUrl() {
    const urlInput = document.getElementById("urlInput").value;
    const resultDiv = document.getElementById("result");

    try {
        const response = await fetch("http://localhost:8080/shortLink", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Accept": "text/plain"
            },
            body: JSON.stringify({urlPlain: urlInput}),
        });

        if (response.status === 200 || response.status === 302) {
            const shortUrlPath = await response.text();
            resultDiv.innerHTML = `<p>Shortened URL: <a href="${shortUrlPath}" target="_blank">${shortUrlPath}</a></p>`;
        } else if (response.status === 406) {
            resultDiv.innerHTML = "<p>Incorrectly formatted URL. Use \"http://\" or \"https://\" format.</p>";
        } else {
            resultDiv.innerHTML = "<p>Failed to shorten URL. Please try again.</p>";
        }
    } catch (error) {
        resultDiv.innerHTML = "<p>Error: Unable to connect to the server.</p>";
    }
}
