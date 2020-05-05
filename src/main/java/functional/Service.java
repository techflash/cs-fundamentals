package functional;

public class Service {

  private final Processor processor = new Processor();

  public void execute(){
    processor.process(this::processStatus);
  }

  public boolean processStatus(ProcessStatus processStatus) {
    return processStatus.START == ProcessStatus.START;
  }
}
