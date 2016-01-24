package SeleniumLogger;

/// <summary>
/// The following class models the indentation on SeleniumLog.exe as closely as possible.
/// This VS Plugin has no access to the actual state of the indentation in SeleniumLog.exe,
/// hence this function is updated just when we are about to write to the output file.
/// </summary>
public class IndentModel
{
  public Integer PendingDelta { get { return _pending_delta; } }
  public Integer CurrentLevel { get { return _level; } }
  public Boolean EmptyTree { get { return _empty_tree; } set {_empty_tree = value; }}
  private Integer _level { get; set; }  //root level = 0
  private Integer _pending_delta { get; set; }
  private Boolean _empty_tree;

  public IndentModel() {
      _empty_tree = true;
      _level = 0;
      _pending_delta = 0;
  }


  public void Indent(Integer delta)
  {
      if (!_empty_tree) {
          if (delta > 0)
          {
              _level++;  // SeleniumLog.exe can only increase level by 1.
          }
      }
  }

  public void Unindent(Integer delta)
  {
      if (!_empty_tree) {
          if ((_level - delta) <= 0)
          {
              _level = 0;
          }
          else
          {
              _level = _level - delta;
          }
      }
  }

  public void pIndent(Integer delta)
  {
      if (!_empty_tree)
      {
          if (delta > 0)
          {
              _pending_delta++;  // SeleniumLog.exe can only increase level by 1.
          }
      }
  }

  public void pUnindent(Integer delta)
  {
      if (!_empty_tree)
      {
          if ((_level - delta) <= 0)
          {
              //_pending_delta = 0;
              _pending_delta = 0 - _level;
          }
          else
          {
              //_pending_delta = _level - delta;
              _pending_delta = 0 - delta;
          }
      }
  }

  public void SimulateIndentations(String FORMATTING_STRING)
  {
      String input = "<;; ;PASS; INDENT; INDENT; PICTIRE; FILE; INDENT; INDENT; UNINDENT;UNINDENT;;>message > 100";

      String res0 = Regex.Replace(input: FORMATTING_STRING, pattern: @"\>..*$", replacement: "");
      String res1 = Regex.Replace(input: res0, pattern: @"\<", replacement: "");
      //remove all whitespaces
      String res2 = Regex.Replace(input: res1, pattern: @" +", replacement: "");
      //remove leading and trailing colons
      String res3 = Regex.Replace(input: res2, pattern: @"^\;*", replacement: "");
      String res4 = Regex.Replace(input: res3, pattern: @"\;*$", replacement: "");

      String[] formatters = res4.Split(';');
      Integer indent_count = 0;
      Integer unindent_count = 0;
      foreach (String formatter in formatters)
      {
          if (formatter == "INDENT")
          {
              if (unindent_count > 0)
              {
                  //log.Pink("Unindent " + unindent_count + " times");
                  Unindent(unindent_count);
                  unindent_count = 0;
              }
              indent_count++;
          }
          else if (formatter == "UNINDENT")
          {
              if (indent_count > 0)
              {
                  //log.Pink("Indent " + indent_count + " times");
                  Indent(indent_count);
                  indent_count = 0;
              }
              unindent_count++;
          }
          else
          {
              // Apply indents or unindents, depending which one has accumulated value
              if (indent_count > 0)
              {
                  //log.Blue("Indent " + indent_count + " times");
                  Indent(indent_count);
                  indent_count = 0;
              }
              else if (unindent_count > 0)
              {
                  //log.Blue("Unindent " + unindent_count + " times");
                  Unindent(unindent_count);
                  unindent_count = 0;
              }
          }
      }

      // Apply remaining indents or unindents, depending which one has accumulated value
      if (indent_count > 0)
      {
          //log.WriteLine("Indent " + indent_count + " times");
          Indent(indent_count);
          indent_count = 0;
      }
      else if (unindent_count > 0)
      {
          //log.WriteLine("Unindent " + unindent_count + " times");
          Unindent(unindent_count);
          unindent_count = 0;
      }

  } // end function

  
  public void CalculatePendingLevel(String FORMATTING_STRING)
  {
	  /*
      String res0 = Regex.Replace(input: FORMATTING_STRING, pattern: @"\>..*$", replacement: "");
      String res1 = Regex.Replace(input: res0, pattern: @"\<", replacement: "");
      //remove all whitespaces
      String res2 = Regex.Replace(input: res1, pattern: @" +", replacement: "");
      //remove leading and trailing colons
      String res3 = Regex.Replace(input: res2, pattern: @"^\;*", replacement: "");
      String res4 = Regex.Replace(input: res3, pattern: @"\;*$", replacement: "");
	  */
	  String res0 = FORMATTING_STRING.replaceAll("\\>..*$", "");
	  String res1 = res0.replaceAll("\\<", "");
	  //remove all whitespaces
	  String res2 = res1.replaceAll(" +", "");
	  //remove leading and trailing colons
	  String res3 = res2.replaceAll("^\\;*", "");
	  String res4 = res3.replaceAll("\\;*$", "");
	  
      _pending_delta = 0;

      String[] formatters = res4.split(";"); 
      Integer indent_count = 0;
      Integer unindent_count = 0;
      //C# foreach (String formatter in formatters)
      for (String formatter : formatters)
      {
          if (formatter == "INDENT")
          {
              if (unindent_count > 0)
              {
                  //log.Pink("Unindent " + unindent_count + " times");
                  pUnindent(unindent_count);
                  unindent_count = 0;
              }
              indent_count++;
          }
          else if (formatter == "UNINDENT")
          {
              if (indent_count > 0)
              {
                  //log.Pink("Indent " + indent_count + " times");
                  pIndent(indent_count);
                  indent_count = 0;
              }
              unindent_count++;
          }
          else
          {
              // Apply indents or unindents, depending which one has accumulated value
              if (indent_count > 0)
              {
                  //log.Blue("Indent " + indent_count + " times");
                  pIndent(indent_count);
                  indent_count = 0;
              }
              else if (unindent_count > 0)
              {
                  //log.Blue("Unindent " + unindent_count + " times");
                  pUnindent(unindent_count);
                  unindent_count = 0;
              }
          }
      }

      // Apply remaining indents or unindents, depending which one has accumulated value
      if (indent_count > 0)
      {
          //log.WriteLine("Indent " + indent_count + " times");
          pIndent(indent_count);
          indent_count = 0;
      }
      else if (unindent_count > 0)
      {
          //log.WriteLine("Unindent " + unindent_count + " times");
          pUnindent(unindent_count);
          unindent_count = 0;
      }

  } // end function
  
}