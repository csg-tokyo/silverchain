package command;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import silverchain.command.Command;

final class CommandTester {

  private final OutputStream stdout = new ByteArrayOutputStream();

  private final OutputStream stderr = new ByteArrayOutputStream();

  private final int status;

  CommandTester(String... args) {
    status = Command.run(new PrintStream(stdout), new PrintStream(stderr), args);
  }

  CommandTester status(int i) {
    assert status == i;
    return this;
  }

  CommandTester stdout(String s) {
    assert stdout.toString().equals(s);
    return this;
  }

  CommandTester stderr(String s) {
    assert stderr.toString().equals(s);
    return this;
  }
}
