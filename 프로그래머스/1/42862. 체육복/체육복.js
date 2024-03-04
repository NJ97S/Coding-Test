function solution(n, lost, reserve) {
    // 숫자 작은 순으로 정렬하고 시작
    lost.sort((a, b) => a - b);
    reserve.sort((a, b) => a - b);
    
    let maxStudent = n - lost.length; // 최솟값에서 시작
    
    let noReservePerson = []; // 빌려줄 수 없는 사람
    
    for (let reservePerson of lost) {
        for (let lostPerson of reserve) {
            if (lostPerson === reservePerson) {
                noReservePerson.push(reservePerson);
                maxStudent++;
            }
        }
    }
    
    for (let lostPerson of lost) {
        // 이 시점에서 noReservePerson에는 중복되는 사람들만 있기 때문에, lost 요소와 겹치면 건너뜀.
        if (noReservePerson.includes(lostPerson)) continue;
        
        for (let reservePerson of reserve) {
            if (noReservePerson.includes(reservePerson)) continue;
            
            // 가능하면 전 번호 사람에게 빌리는 것이 유리하기 때문에, 이를 먼저 조건에 넣음.
            // 조건 충족하면 최대 학생 수 증가 -> 반복문 탈출
            if (lostPerson - 1 === reservePerson || lostPerson + 1 === reservePerson) {
                noReservePerson.push(reservePerson);
                maxStudent++;
                break;
            }
        }
    }
    
    return maxStudent;
}