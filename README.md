# ATM-Interface
The ATM Interface project is a console-based application implemented in Java that simulates the functionalities of an Automated Teller Machine (ATM). It provides users with a user-friendly interface to perform various banking operations such as checking account balance, withdrawing funds, depositing funds, transferring funds to other accounts, and viewing transaction history.

Key Features:

User Authentication: The application prompts the user to enter their user ID and PIN for authentication before allowing access to the ATM functionalities. It verifies the entered credentials against a predefined set of user IDs and corresponding PINs.

Account Balance: Users can view their account balance on the screen. The application retrieves the account balance associated with the authenticated user and displays it.

Withdrawals: Users can withdraw funds from their accounts. The application validates the withdrawal amount, ensuring it doesn't exceed the available account balance. After a successful withdrawal, the account balance is updated, and the transaction is recorded in the user's transaction history.

Deposits: Users can deposit funds into their accounts. The application verifies the deposit amount and adds it to the account balance. The transaction is recorded in the user's transaction history.

Fund Transfers: Users can transfer funds from their account to another account within the system. The application verifies the recipient's user ID and validates the transfer amount against the available account balance. The transaction is recorded in both the sender's and recipient's transaction history, and the respective account balances are updated.

Transaction History: Users can view their transaction history, which shows a record of all previous transactions, including withdrawals, deposits, and transfers.

The project follows object-oriented programming principles, utilizing classes such as User to represent user accounts and encapsulating related data and methods. It incorporates error handling to ensure valid user input and proper handling of exceptional scenarios, such as insufficient funds or incorrect credentials.
