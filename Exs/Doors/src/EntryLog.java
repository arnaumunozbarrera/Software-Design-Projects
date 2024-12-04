import java.time.LocalDateTime;

public class EntryLog {
  private String code;
  private String doorId;
  private LocalDateTime timestamp;
  private boolean doorLocked;

  public EntryLog(String code, String doorId, boolean doorLocked) {
    this.code = code;
    this.doorId = doorId;
    this.timestamp = LocalDateTime.now(); // Almacena la fecha y hora actuales
    this.doorLocked = doorLocked;
  }

  @Override
  public String toString() {
    return
        "code='" + code + '\'' +
        ", doorId='" + doorId + '\'' +
        ", timestamp=" + timestamp +
        ", doorLocked=" + doorLocked +
        '\n';
  }
}
