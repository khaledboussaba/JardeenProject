let listeIdSelected="";
function setJSValue(){
    document.getElementById('myForm:jsValue').value = listeIdSelected.toString();
}

const selection = Selection.create({

    // Class for the selection-area
    class: 'selection',

    // All elements in this container can be selected
    selectables: ['.box-wrap > div'],

    // The container is also the boundary in this case
    boundaries: ['.box-wrap'],

    onSelect({target, originalEvent, selectedElements}) {


 
        // Check if clicked element is already selected
        const selected = target.classList.contains('selected');
        const occupee = target.classList.contains('occupee');

        // // Remove class if the user isn't pressing the control key or ⌘ key and the
        // // current target is already selected
        // if (!originalEvent.ctrlKey && !originalEvent.metaKey) {
        //     // Remove class from every element that is selected
        //     for (const el of selectedElements) {
        //         el.classList.remove('selected');
        //     }
        //     // Clear previous selection
        //     this.clearSelection();
        //     listeIdSelected="";

        // }

        // //TODO VERIFIER QUE SI LE DEUXIEME ELEMENT EST OCCCUPER LAJOUTER 
        // if (!selected ) {
        //     // Select element
        //     target.classList.add('selected');
        //     this.keepSelection();
        //     //REDA
        //     listeIdSelected+=target.id+"-";
        //     console.log("(ON SELECT) Etat listeIdSelected  : "+listeIdSelected);
        // } else {
        //     // Unselect element
        //     target.classList.remove('selected');
        //     this.removeFromSelection(target);
        //     //REDA
        //     listeIdSelected="";
        //     console.log("(ON SELECT) Etat listeIdSelected  : "+listeIdSelected);
        // }

        ////NEW 
        // Remove class if the user isn't pressing the control key or ⌘ key and the
        // current target is already selected
        if (!originalEvent.ctrlKey && !originalEvent.metaKey) {
            // Remove class from every element that is selected
            for (const el of selectedElements) {
                el.classList.remove('selected');
            }
            // Clear previous selection
            this.clearSelection();
            listeIdSelected="";

        }

        //TODO VERIFIER QUE SI LE DEUXIEME ELEMENT EST OCCCUPER LAJOUTER 
        if (occupee) {
            // Select element
            target.classList.add('selected');
            this.keepSelection();
            //REDA
            listeIdSelected+=target.id+"-";
            console.log("(ON SELECT) Etat listeIdSelected  : "+listeIdSelected);
        } else {
            // Unselect element
            target.classList.remove('selected');
            this.removeFromSelection(target);
            //REDA
            listeIdSelected="";
            console.log("(ON SELECT) Etat listeIdSelected  : "+listeIdSelected);
        }
    },

    onStart({selectedElements, originalEvent}) {

        // Remove class if the user isn't pressing the control key or ⌘ key
        if (!originalEvent.ctrlKey && !originalEvent.metaKey) {

            // Unselect all elements
            for (const el of selectedElements) {
                el.classList.remove('selected');
            }

            // Clear previous selection
            this.clearSelection();
            //REDA
            listeIdSelected="";
            console.log("(ON START) Etat listeIdSelected  : "+listeIdSelected);

        }
    },

    //TODO GERER LE CAS OU LA CASE EST DEJA AFFECTEE A UNE PARCELLE 
    onMove({selectedElements, changedElements: {removed}}) {

        // Add a custom class to the elements that where selected.
        //TESTER SI UN DES ELEMENTS SELECTIONNEES EST UN EMPLACEMENT OCCUPEE
        var containsValueOccuped=false;
        
        for (const el of selectedElements) {
            if(el.classList.contains('occupee')){
                containsValueOccuped=true;  
            };
        } 

        if(containsValueOccuped == false){
            for (const el of selectedElements) {
                el.classList.add('selected');
                 //------REDA
                if(!listeIdSelected.includes(el.id)){
                    listeIdSelected+=el.id+"-";            
                }
            }     
        }

        // Remove the class from elements that where removed
        // since the last selection
        for (const el of removed) {
            el.classList.remove('selected');
            //------REDA
            listeIdSelected="";
        }
        console.log("(ON MOVE) containsValueOccuped  : "+containsValueOccuped);
        console.log("(ON MOVE) Etat listeIdSelected  : "+listeIdSelected);

    },

    onStop() {
        this.keepSelection();
    }
});
