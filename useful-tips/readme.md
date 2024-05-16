### To disable chrome security , open cmd and cd into the directory where chrome.exe is present and run the below command there
- Disabling security will help you avoid CORS, SSL, Redirections errors which are stopped by chrome by default

```
chrome.exe --user-data-dir="C:\Users\user\Documents\my\data" --disable-web-security
```
