 # TODO - kavach-backend fixes

## Step 1
Fix entity/model file `src/main/java/com/kavach/kavach_backend/model/SOSalert.java`:
- Move imports to top-level
- Remove extra braces
- Ensure public class name matches file/class (`SOSAlert`)

## Step 2 (done)
Fix SOS components to compile:
- `SOSAlertService.java`: ensure imports are top-level, fix braces
- `SOSAlertController.java`: set package to `com.kavach.kavach_backend.controller`
- `SOSAlertRepository.java`: remove stray empty class, set package to `com.kavach.kavach_backend.repository`


## Step 3
Align repository file naming/packages for User:
- If needed, ensure `UserRepository` is in `com.kavach.kavach_backend.repository` and correct file name/case.

## Step 4
Run build/tests:
- `mvn clean test` or `mvn test`

## Step 5
Verify endpoints (compile-time success):
- Ensure `/api/sos/trigger`, `/api/sos/{phone}`, `/api/sos/all` exist and match frontend calls if applicable.

