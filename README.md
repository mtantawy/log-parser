# Log Parser
_This and other related projects are just me exploring and learning, so don't fret about'em_

## What is it?
This is a simple CLI tool that given a `Parser Type` and a `file path` reads the log file (and tails it), parses line by line to understand the different `log line` fields, and forwards the parsed `log line` to a server or another tool that collects them and forwards them to a server (TBD).

The big picture is that I want to implement something similar to ELK or TICK stacks, I don't plan to re-implement everything (yeah I am not re-writing ES) but smaller scripts like parsing and collecting logs, and basically whatever feels interesting to me!

Oh yeah, and I am mainly going to run this on my RPis so that I have visibility over'em, so log files might be extended to sensor readings as well!

## Features
* Parse existing log file
* Tail the given log file
* Support multiple log file types (I call it `Parser Type`)

## Next Steps
* Increase test coverage wherever it makes sense (on-going goal)
* Cover at least one more type of log files (syslog?)
* Decide whether to forward to server directly or create another tool that handles that, mainly to also handle retries and buffering, etc ...

### Note
As I am mainly doing this to learn, and i don't prefer using libraries that do things out-of-the-box, i plan to keep it simple, stupid, until I feel like taking it to the next level.

For example, there is a ready-to-use Tailer lib by Apache Commons, but i did learn a few things trying out different approaches to file handling in Java using both Legacy and NIO.