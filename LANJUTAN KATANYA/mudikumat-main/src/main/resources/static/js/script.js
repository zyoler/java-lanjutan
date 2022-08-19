const root = $(':root');
const tombolTemaGelap = $('#tema-gelap');

if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
    root.addClass('gelap');
    tombolTemaGelap.prop('checked', true);
}

tombolTemaGelap.change(function () {
    root.addClass('transisi-latar');
    if (!root.hasClass('gelap')) {
        root.addClass('gelap');
    } else {
        root.removeClass('gelap');
    }
    setTimeout(function () {
        root.removeClass('transisi-latar');
    }, 500);
});

$.fn.ubahTeks = function (teks) {
    this.find('.texts li:first').text(teks);
}

$.fn.tampilkan = function () {
    this.css('display', 'flex');
}

let modalTerbuka = [];

$.fn.bukaModal = function () {
    const modal = $('#modal');
    $(modalTerbuka[modalTerbuka.length - 1]).hide();
    modalTerbuka.push(this);
    modal.tampilkan();
    this.tampilkan();
    $(this).find('.bisa-discroll').scrollTop(0);
    $(this).find('input').first().focus();
    setTimeout(function () {
        modal.css('pointer-events', 'all');
    }, 150);
    modal.animate({
        opacity: 1
    }, 0);
}

$.fn.serializeObject = function() {
    let object = {};
    let array = this.serializeArray();
    $.each(array, function() {
        if (object[this.name] !== undefined) {
            if (!object[this.name].push) {
                object[this.name] = [object[this.name]];
            }
            object[this.name].push(this.value || '');
        } else {
            object[this.name] = this.value || '';
        }
    });
    return object;
};

$.fn.getNilai = function() {
    let nilai = $(this).val();
    if (nilai !== '') {
        return nilai;
    } else {
        return null;
    }
}

$.fn.getNilaiKey = function(key) {
    let nilai = $(this).val();
    if (nilai !== '' && nilai !== null) {
        return {[key]: nilai};
    } else {
        return null;
    }
}

function tampilkanToast(teks) {
    const toast = $('#toast');
    toast.text(teks);
    toast.css('opacity', 1);
    toast.delay(2000).animate({
        opacity: 0
    });
}

function tutupModal() {
    const modal = $('#modal');
    const modalSaatIni = $(modalTerbuka[modalTerbuka.length - 1]);
    if (modalTerbuka.length > 1) {
        modalSaatIni.hide();
        $(modalTerbuka[modalTerbuka.length - 2]).tampilkan();
        modalTerbuka.pop();
    } else {
        setTimeout(function () {
            modal.css('pointer-events', 'none');
        }, 150);
        setTimeout(function () {
            modalSaatIni.hide();
            modalTerbuka.pop();
            modal.hide();
        }, 300);
        modal.css('opacity', 0);
    }
}

function konfirmasi(judul, pesan, ya, tidak) {
    $('#konfirmasi .judul').text(judul);
    $('#konfirmasi .pesan').text(pesan);
    $('#konfirmasi').bukaModal();
    $('#konfirmasi .tombol-tutup').off('click');
    $('#konfirmasi .tombol-tutup').click(function() {
        tidak();
    });
    $('#konfirmasi .tombol-ya').off('click');
    $('#konfirmasi .tombol-ya').click(function() {
        ya();
        tutupModal();
    });
}