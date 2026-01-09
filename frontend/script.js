const BASE_URL = "http://localhost:8084/veridoc";

/* ================= TAB SWITCH ================= */
function showUpload() {
    uploadTab.classList.add("active");
    verifyTab.classList.remove("active");
    uploadBtn.classList.add("active");
    verifyBtn.classList.remove("active");
}

function showVerify() {
    uploadTab.classList.remove("active");
    verifyTab.classList.add("active");
    uploadBtn.classList.remove("active");
    verifyBtn.classList.add("active");
}

/* ================= FILE NAME DISPLAY ================= */
uploadFile.addEventListener("change", () => {
    uploadFileName.innerText =
        uploadFile.files.length ? uploadFile.files[0].name : "No file selected";
});

verifyFile.addEventListener("change", () => {
    verifyFileName.innerText =
        verifyFile.files.length ? verifyFile.files[0].name : "No file selected";
});

/* ================= UPLOAD ================= */
uploadForm.addEventListener("submit", e => {
    e.preventDefault();

    uploadSuccess.style.display = "none";
    uploadError.style.display = "none";
    uploadCode.style.display = "none";

    fetch(`${BASE_URL}/upload`, {
        method: "POST",
        body: new FormData(uploadForm)
    })
    .then(res => res.json())
    .then(data => {
        uploadSuccess.innerText = "Document uploaded successfully.";
        uploadSuccess.style.display = "block";

        uploadCode.innerText = "Verification Code: " + data.verificationCode;
        uploadCode.style.display = "block";

        code.value = data.verificationCode;
    })
    .catch(() => {
        uploadError.innerText = "Upload failed. Please try again.";
        uploadError.style.display = "block";
    });
});

/* ================= VERIFY (FIXED & WORKING) ================= */
verifyForm.addEventListener("submit", e => {
    e.preventDefault();

    verifyResult.style.display = "none";
    verifyResult.classList.remove("success", "error");

    fetch(`${BASE_URL}/verify/${code.value}`, {
        method: "POST",
        body: new FormData(verifyForm)
    })
    .then(res => res.text())
    .then(result => {
        const response = result.trim().toLowerCase();

        if (response === "valid file") {
            verifyResult.innerText = "✅ Document is VALID";
            verifyResult.classList.add("success");
        } else {
            verifyResult.innerText = "❌ Document is INVALID / TAMPERED";
            verifyResult.classList.add("error");
        }

        verifyResult.style.display = "block";
    })
    .catch(() => {
        verifyResult.innerText = "❌ Verification failed due to server error";
        verifyResult.classList.add("error");
        verifyResult.style.display = "block";
    });
});
