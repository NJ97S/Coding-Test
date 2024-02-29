function solution(cards1, cards2, goal) {
    let count = 0;
    
    while (count !== goal.length) {
        for (let i = 0; i < goal.length; i++) {
         let goalWord = goal[i];
        
         if (cards1[0] === goalWord) {
             cards1.shift();
             count++;
         } else if (cards2[0] === goalWord) {
             cards2.shift();
             count++;
         } else return 'No'
     }
    }
    
    return 'Yes'
}