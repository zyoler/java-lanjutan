$('.tombol-login').click(function (event) {
    event.preventDefault();
    $('#login').bukaModal();
});

$('#form-login .deskripsi').textillate({autoStart: false, in: {effect: 'rollIn'}});

$('#form-periksa').submit(function (event) {

    event.preventDefault();

    let notifikasi = $('#form-periksa .notifikasi');

    $.post({
        url: '/api/login/periksa',
        data: $('#form-periksa').serialize(),
        success: function (response) {
            notifikasi.empty();
            $('#form-periksa>.input>*').removeClass('gagal');
            $('#form-periksa').hide();
            $('#id').val($('#periksa').val());
            $('#nama').text(response.nama);
            let deskripsi = $('#form-login .deskripsi');
            deskripsi.ubahTeks(response.deskripsi);
            $('#form-login').tampilkan();
            $('#kata-sandi').focus();
            deskripsi.textillate('in');
        },
        error: function (response) {
            notifikasi.text(response.responseJSON.pesan);
            $('#form-periksa>.input>*').addClass('gagal');
            notifikasi.show();
            $('#periksa').focus();
        }
    });
});

$('#form-login').submit(function (event) {

    event.preventDefault();

    $('#tombol-login').prop('disabled', true);

    const notifikasi = $('#form-login .notifikasi');

    $.post({
        url: '/api/login/login',
        data: $('#form-login').serialize(),
        success: async function (response) {
            $('#form-login>.input>*').removeClass('gagal');
            notifikasi.text(response.pesan);
            notifikasi.addClass('berhasil');
            notifikasi.show();
            await new Promise(r => setTimeout(r, 1000));
            window.location.replace('/');
        },
        error: function (response) {
            notifikasi.text(response.responseJSON.pesan);
            $('#form-login>.input>*').addClass('gagal');
            notifikasi.show();
            $('#tombol-login').prop('disabled', false);
            $('#kata-sandi').focus();
        }
    });
});

$('#tombol-kembali').click(function () {
    $('#form-login .notifikasi').empty();
    $('#form-login>.input>*').removeClass('gagal');
    $('#form-login').hide();
    $('#form-periksa').tampilkan();
    $('#periksa').focus();
})