document.getElementById('lucky-button').addEventListener('click', function() {
    const query = document.getElementById('search-box').value.trim();
    if (query === '') {
        alert('Lütfen bir arama terimi girin.');
        return;
    }

    // Google'ın "İ’m Feeling Lucky" işlevini taklit etme
    const url = `https://www.google.com/search?q=${encodeURIComponent(query)}`;
    window.location.href = url;
});

document.getElementById('image-search-button').addEventListener('click', function(event) {
    event.preventDefault(); // Formun gönderilmesini engelle
    const query = document.getElementById('search-box').value.trim();
    if (query === '') {
        alert('Lütfen bir arama terimi girin.');
        return;
    }
    const url = `https://www.google.com/search?tbm=isch&q=${encodeURIComponent(query)}`;
    window.location.href = url;
});
