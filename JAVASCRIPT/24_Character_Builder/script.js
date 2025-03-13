
document.querySelectorAll('.imgBtn').forEach(item => {
    item.addEventListener('click', event => {
        var newPart = event.target.getAttribute("data-part");
        var newImg = event.target.getAttribute('data-new-image');
        if (newPart === "helmet") {
            document.getElementById('helmetContainer').src =`/JAVASCRIPT/24_Character_Builder/1739258159513_minecaft_assets/${newImg}`;
        } else if (newPart === "armor") {
            document.getElementById('armorContainer').src = `/JAVASCRIPT/24_Character_Builder/1739258159513_minecaft_assets/${newImg}`;
        } else if (newPart === "leggings") {
            document.getElementById('leggingsContainer').src = `/JAVASCRIPT/24_Character_Builder/1739258159513_minecaft_assets/${newImg}`;
        } else if (newPart === "boots") {
            document.getElementById('bootsContainer').src = `/JAVASCRIPT/24_Character_Builder/1739258159513_minecaft_assets/${newImg}`;
        }
    });
});