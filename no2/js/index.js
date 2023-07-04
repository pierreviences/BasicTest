
function geocodeLatLng() {
    const input = $("#latlng").val();
    const [lat, lng] = input.split(",").map(parseFloat);
    const url = `https://dev.virtualearth.net/REST/v1/Locations/${lat},${lng}?o=json&key=AnmdP5Ko_zhVEfwvqCrVPEKtDs9PxPU5yji-PswMMxn-dHltT7Jngb_ONGS7fSUX`;
    const cacheKey = `${lat}-${lng}`;
    const cachedLocation = sessionStorage.getItem(cacheKey);
    if (cachedLocation) {
        displayLocation(cachedLocation, lat, lng);
        return;
    }

    $.ajax({
        url: url,
        dataType: "json"
    })
        .done(function (data) {
            if (data && data.resourceSets && data.resourceSets.length > 0 && data.resourceSets[0].resources && data.resourceSets[0].resources.length > 0) {
                const address = data.resourceSets[0].resources[0].address.formattedAddress;
                sessionStorage.setItem(cacheKey, address);
                displayLocation(address, lat, lng);
            } else {
                alert("Tidak ada hasil yang ditemukan");
            }
        })
        .fail(function (error) {
            alert("Terjadi kesalahan dalam melakukan reverse geocoding, pesan error : " + error.message);
        });
}

function displayLocation(location, lat, lng) {
    const map = new Microsoft.Maps.Map($("#map")[0], {
        credentials: 'AnmdP5Ko_zhVEfwvqCrVPEKtDs9PxPU5yji-PswMMxn-dHltT7Jngb_ONGS7fSUX',
        center: new Microsoft.Maps.Location(lat, lng),
        zoom: 12
    });
    const locationPin = new Microsoft.Maps.Location(lat, lng);
    const pin = new Microsoft.Maps.Pushpin(locationPin, { draggable: false });
    map.entities.push(pin);
    $("#location").html(location);
}

function initMap() {
    const defaultLatLng = '40.714224,-73.961452';
    $("#latlng").val(defaultLatLng);
    geocodeLatLng();
}
