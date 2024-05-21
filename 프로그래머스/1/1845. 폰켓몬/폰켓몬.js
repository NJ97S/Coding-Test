function solution(nums) {
    const POKEMONS_SET = new Set(nums);
    let pokemonsArr = Array.from(POKEMONS_SET);
    
    const NUM_OF_POKEMONS = nums.length / 2;
    
    let answer = 0;
    
    for (i = 1; i <= NUM_OF_POKEMONS; i++) {
        if (!pokemonsArr.length) break;
        
        answer++;
        pokemonsArr.pop();
    }
    
    return answer;
}