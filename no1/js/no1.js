function moveDisk(numberOfDiscs, sourceTower, auxiliaryTower, destinationTower) {
    if (numberOfDiscs === 1) {
        console.log(`Pindahkan Disk 1 dari menara ${sourceTower} ke menara ${destinationTower}.`);
        return 1;
    }
    const step1 = moveDisk(numberOfDiscs - 1, sourceTower, destinationTower, auxiliaryTower);
    console.log(`Pindahkan Disk ${numberOfDiscs} dari menara ${sourceTower} ke menara ${destinationTower}.`);
    const step2 = moveDisk(numberOfDiscs - 1, auxiliaryTower, sourceTower, destinationTower);
    return step1 + step2 + 1;
}
function howManySteps(discs) {
    const towerA = 'A';
    const towerB = 'B';
    const towerC = 'C';
    console.log("Langkah-langkah pemindahan :");
    const steps = moveDisk(discs, towerA, towerB, towerC);
    console.log(`Total langkah yang diperlukan : ${steps}`);
}
howManySteps(3);
