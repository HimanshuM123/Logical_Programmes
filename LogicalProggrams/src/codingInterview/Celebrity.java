package codingInterview;

public class Celebrity {
    // Function to find the celebrity
    public int findCelebrity(int n) {
        // Step 1: Find the potential celebrity
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // Step 2: Verify if the candidate is actually the celebrity
        for (int i = 0; i < n; i++) {
            // Candidate should not know anyone else, and everyone should know the candidate
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }

        return candidate;
    }

    // Helper function to check if person a knows person b
    public boolean knows(int a, int b) {
        // This function is part of the problem, you would implement it based on the matrix M
        // For example, you can use a pre-defined matrix M to simulate the function
        return M[a][b] == 1;
    }

    // Sample matrix M for testing purposes
    int[][] M = {
        {0, 1, 0},
        {0, 0, 0},
        {0, 1, 0}
    };
    
    public static void main(String[] args) {
        Celebrity celeb = new Celebrity();
        int result = celeb.findCelebrity(3);
        System.out.println("The celebrity is: " + result);
    }
}

/*


n = 3

Matrix:
0 knows 1
1 knows nobody
2 knows 1

*/