function solution(name, yearning, photo) {
    const peoplePoint = {};
    for (let i = 0; i < name.length; i++) {
        peoplePoint[name[i]] = yearning[i];
    }
    
    let totalPoint = [];
    
    for (let group of photo) {
        let groupPoint = 0;
        for (let person of group) {
            if (person in peoplePoint) groupPoint += peoplePoint[person]
        }
        totalPoint.push(groupPoint)
    }
    
    return totalPoint
}