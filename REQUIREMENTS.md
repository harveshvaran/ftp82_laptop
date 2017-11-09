
# High level requirements

We need to build a leave management application. This is an application where employee details (id, name, etc.) are stored
along with their current leave balance. All employees have a manager, who is also an employee, except the CEO of the company
who does not have a manager.

Employees can apply for leave in this portal. These leave applications go to their manager for approval. The manager can approve
or deny the leave application.

As said earlier, employees have a leave balance; this cannot go negative. At any time, an employee can see his/her applications
and their statuses.

# Out-Of-Scope
  * Authentication of the employees, password, password-reset etc.
  * Cancellation of leave applications (applications which are in the pending-approval status, approved status or denied status).
  
# Must-Have
  * All the high-level requirements above
  * Same functionality available via
     * Cli
     * Curl
     * Browser
  * Validations, with error messages, both on 
     * the server side, to make sure the data is clean no matter what the source and,
     * the client side, to provide a responsive user interface
     * Type validations
     * Semantic validations
        * A new leave application should not overlap with an existing leave application in the approved or pending status
        * Start date must not be in the past
        * End date should be equal to or greater than the start date

# Nice-To-Have
  * Mail alert to manager when his/her employee applies for leave
  * Mail alert to manager when his/her manager approves/denies leave application
  * Handle leave applications in the past differently
  * Calculate number of days of application leave automatically using
    * Weekend calculations
    * Company calendar which specifies company holidays
  * Different types of leave
    * Earned leave/Privileged leave
    * Sick leave
    * Maternity/Paternity leave
    
# Great-To-Have
  * Photos for employee in the database
  * Escalation when manager does not approve within some SLA
  * Sorting options on all tables
  * 'quick filter' options on all tables
  * Employees to re-edit their leave applications, esp. those in the pending status
  * A way to handle leave already availed in the past
  * Ability for managers to review and revisit their decisions
